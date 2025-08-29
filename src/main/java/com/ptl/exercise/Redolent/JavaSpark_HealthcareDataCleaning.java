package com.ptl.exercise.redolent;

public class JavaSpark_HealthcareDataCleaning {
    
}

//There will be 1 error/failure - because of ambigous "fullName" in generateFullName method
//I dont know how to solve it yet
/* 
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Encoders;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SparkSession;
import static org.apache.spark.sql.functions.col;
import static org.apache.spark.sql.functions.concat_ws;

//要注意上面的import要有

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
        Dataset<Row> medicalCleaned = medicalDs.withColumnRenamed("fullName", "medicalFullName");

        Dataset<Row> eligibilityWithFullName = eligibilityDs.withColumn("eligibilityFullName",
            concat_ws(" ", col("firstName"), col("lastName")));

        return medicalCleaned.join(eligibilityWithFullName, "memberId")
            .drop("medicalFullName") 
            .withColumnRenamed("eligibilityFullName", "fullName")
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