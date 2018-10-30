package com.audting;

import java.text.ParseException;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.hibernate.envers.AuditReader;
import org.hibernate.envers.AuditReaderFactory;
import org.hibernate.envers.query.AuditQuery;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.audting.model.Account;
import com.audting.model.AccountHistory;
import com.audting.model.Address;
import com.audting.model.City;
import com.audting.model.Country;
import com.audting.model.Project;
import com.audting.model.State;
import com.audting.query.utils.AuditQueryResult;
import com.audting.query.utils.AuditQueryUtils;
import com.audting.repository.AddressRepository;
import com.audting.repository.CityRepository;
import com.audting.repository.CountryRepository;
import com.audting.repository.ProjectRepository;
import com.audting.repository.StateRepository;
import com.audting.service.AccountService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AudtingEntityObjectsApplicationTests {

    @Autowired
    private AccountService accountService;

    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    private AddressRepository addressRepository;

    @Autowired
    private ProjectRepository projectRepository;

    AuditReader auditReader;
    Account account = null;
    Address address = null;
    City city = null;

    @Before
    public void before() {
        auditReader = AuditReaderFactory.get(entityManager);

    }

    @Test
    public void contextLoads() {
    }

    // step : 1 Mock the data
    @Test
    public void mockData() {
        Country country = new Country("India");

        State state = new State("Telagana");
        state.setCountry(country);

        City city = new City("Hyderabad");
        city.setState(state);

        Address address1 = new Address("cyber gateway", "hitech city");
        address1.setCity(city);

        Account account = new Account("Sateesh");
        account.setAddress(address1);
        this.accountService.save(account);

    }

    // @Test
    // @Transactional
    public void changeAddressToAccount() {
        this.account = this.accountService.getAccountById(2L);
        this.account.setAddress(this.addressRepository.findById(5L).get());
        this.account = this.accountService.update(this.account);
        Project project = this.projectRepository.findById(1L).get();
        project.setAccount(this.account);
        this.projectRepository.save(project);

    }

    private AccountHistory getAccountHistory(AuditQueryResult<Account> auditQueryResult) {
        return new AccountHistory(auditQueryResult.getEntity(), auditQueryResult.getRevision(),
                auditQueryResult.getType());
    }

    // Step : 3 get the results
    @Test
    @Transactional
    public void getRevisions() throws ParseException {
        try {
            System.out.println("hi");
            AuditQuery auditQuery = auditReader.createQuery().forRevisionsOfEntity(Account.class, false, false);
            List<AuditQueryResult<Account>> list = AuditQueryUtils.getAuditQueryResultsWithRevInfo(auditQuery,
                    Account.class);
            System.out.println("size : " + list.size());
            list.stream().map(res -> getAccountHistory(res)).collect(Collectors.toList())
                    .forEach(res -> System.out.println("Account Name : " + res.getAccount().getName() + ", addredss : "
                            + res.getAccount().getAddress().getArea() + ", modified by : "
                            + res.getRevision().getUserName() + ", revision type : " + res.getRevisionType()));
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }

    }

}
