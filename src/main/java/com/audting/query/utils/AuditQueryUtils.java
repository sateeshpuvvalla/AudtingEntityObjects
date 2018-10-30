package com.audting.query.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.hibernate.envers.query.AuditQuery;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class AuditQueryUtils {

    public static <T> List<AuditQueryResult<T>> getAuditQueryResultsWithRevInfo(AuditQuery auditQuery, Class<T> clazz) {
        List<?> results = auditQuery.getResultList();
        if (results == null)
            return new ArrayList<>();
        System.out.println("results : " + results.size());
        return results.stream().filter(res -> (res instanceof Object[])).map(res -> (Object[]) res)
                .map(res -> AuditQueryResultUtils.getAuditQueryResultsWithRevInfo(res, clazz))
                .collect(Collectors.toList());

    }

    public static <T> List<T> getAuditQueryResultsOnlyEntities(AuditQuery auditQuery, Class<T> clazz) {
        List<?> results = auditQuery.getResultList();
        if (results == null)
            new ArrayList<T>();

        return results.stream().filter(res -> (clazz.isInstance(res))).map(res -> clazz.cast(res))
                .collect(Collectors.toList());
    }

}
