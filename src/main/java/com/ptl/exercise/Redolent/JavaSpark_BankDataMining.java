package com.ptl.exercise.redolent;

public class JavaSpark_BankDataMining {
    
}



/* 
package com.hackerrank.spark.job;

import com.hackerrank.spark.base.JobBase;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SparkSession;
import org.apache.spark.sql.functions;
import java.util.Map;
import java.util.stream.Collectors;


public class FinanceJob extends JobBase {
    static {
        //init sparkSession here
        sparkSession = SparkSession.builder()
                .appName("Finance Data Mining")
                .master("local")
                .getOrCreate();
    }

    @Override
    public Dataset<Row> extractValidTransactions(Dataset<Row> accountsDf, Dataset<Row> transactionDf) {
        // Join accounts with transactions to get valid transactions
        Dataset<Row> accountsAlias1 = accountsDf.as("accounts1");
        Dataset<Row> accountsAlias2 = accountsDf.as("accounts2");
        Dataset<Row> transactionsAlias = transactionDf.as("transactions");

        Dataset<Row> validTransactions = transactionsAlias.join(accountsAlias1, transactionsAlias .col("fromAccountNumber").equalTo(accountsAlias1.col("accountNumber")))
.join(accountsAlias2, transactionsAlias.col("toAccountNumber").equalTo(accountsAlias2.col("accountNumber"))) .filter(transactionsAlias.col("transferAmount").leq(accountsAlias1.col("balance")))
.select(transactionsAlias.col("fromAccountNumber"), transactionsAlias.col("toAccountNumber"), transactionsAlias.col("transferAmount")) .distinct(); 
        return validTransactions;
    }


//good. continue next method
    @Override
    public Long distinctTransactions(Dataset<Row> transactionsDf) {
        // Count distinct fromAccountNumber in transactionsDf
        long count = transactionsDf.select("fromAccountNumber").distinct().count();
        return count;
    }

    @Override
    public Map<String, Long> transactionsByAccount(Dataset<Row> transactionsDf) {
        // Group by fromAccountNumber and count transactions, then get top 10
        Map<String, Long> result = transactionsDf.groupBy("fromAccountNumber")
                .count()
                .orderBy(functions.col("count").desc())
                .limit(10)
                .collectAsList()
                .stream()
                .collect(Collectors.toMap(
                        row -> row.getString(0),
                        row -> row.getLong(1)
                ));

        return result;
    }
}
*/