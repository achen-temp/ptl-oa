package com.ptl.exercise.Redolent;

public class JavaSpark_BankDataCleaning {
    
}

//There will be 1 error/failure - because of ambigous "fullName" in generateFullName method
//I dont know how to solve it yet
/* 
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Encoders;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SparkSession;
import org.apache.spark.sql.functions.*;

public class DataCleaningJob extends JobBase {

    static {
        sparkSession = SparkSession.builder()
                .appName("Data Cleaning")
                .master("local")
                .getOrCreate();
    }

    @Override
    public Dataset<Medical> filterMedical(Dataset<Eligibility> eligibilityDs, Dataset<Medical> medicalDs) {
        return medicalDs.join(eligibilityDs,
                medicalDs.col("memberId").equalTo(eligibilityDs.col("memberId")),
                "inner")
                .select(medicalDs.col("*"))
                .as(Encoders.bean(Medical.class));
    }

    @Override
    public Dataset<Medical> generateFullName(Dataset<Eligibility> eligibilityDs, Dataset<Medical> medicalDs) {
        Dataset<Row> eligibilityWithFullName = eligibilityDs.withColumn("fullName",
                concat_ws(" ", col("firstName"), col("lastName")));
        return medicalDs.join(eligibilityWithFullName, "memberId")
                .select(medicalDs.col("*"), eligibilityWithFullName.col("fullName"))
                .as(Encoders.bean(Medical.class));
    }

    @Override
    public String findMaxPaidMember(Dataset<Medical> medicalDs) {
        Medical maxPaidMedical = medicalDs.orderBy(col("paidAmount").desc())
                .limit(1)
                .collectAsList()
                .get(0);
        return maxPaidMedical.getMemberId();
    }

    @Override
    public Long findTotalPaidAmount(Dataset<Medical> medicalDs) {
        return medicalDs.agg(sum("paidAmount")).first().getLong(0);
    }
}
*/