package com.ptl.exercise.TMobile;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.cassandra.core.cql.Ordering;
import org.springframework.data.cassandra.core.cql.PrimaryKeyType;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn;
import org.springframework.data.cassandra.core.mapping.Table;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Write a controller to receive a Rest request, with basic auth, and clientId, and content type json headers,
 * store all the details to a database  --- POST
 * configure database
 * code does not need to compile
 * Assume this is in a spring boot application, application.properties is loaded etc.
 */
//TODO: #1 write controller class first
@RestController
@RequestMapping("/codeTest")
class CodeTestController {
    @Autowired
    CodeTestRepository repo;

    @PostMapping(value = "/add")
    public ResultDTO addRequest(@RequestBody CodeTestRequest request) {
        try {
            repo.save(request);
        } catch (Exception e) {
            //500
            if (/*e.getCode()*/e.getMessage() == "204") {
                return new ResultDTO("Result", "No Content");
            } else if (/*e.getCode()*/e.getMessage() == "500") {
                return new ResultDTO("Result", "Error while processing request");
            }
        }
        return new ResultDTO("Result", "Success"); //200
    }
}

//created
class ResultDTO {
    String name;
    String value;

    public ResultDTO(String name, String value) {
        this.name = name;
        this.value = value;
    }
}


//TODO: #2 CodeTestRepository - primary key is transactionId, dbc:cassandra://10.250.250.250:9042/code_test
@Repository
interface CodeTestRepository extends CassandraRepository<String, CodeTestRequest> {
    void save(CodeTestRequest request);
}

@Table
class CodeTestRequest {
    @PrimaryKey //OR
    @PrimaryKeyColumn(
            name = "transactionId",
            ordinal = 2,
            type = PrimaryKeyType.CLUSTERED,
            ordering = Ordering.ASCENDING
    )
    private String transactionId;

    @Column
    private String paramName;

    @Column
    private String paramValue;

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public String getParamName() {
        return paramName;
    }

    public void setParamName(String paramName) {
        this.paramName = paramName;
    }

    public String getParamValue() {
        return paramValue;
    }

    public void setParamValue(String paramValue) {
        this.paramValue = paramValue;
    }
}

/**
 * #################################################################
 * # application.properties
 * code.test.username=newemployee
 * code.test.password=shouldbeencrypted
 * //TODO: #3 db properties - use above credentials
 * spring.data.cassandra.keyspace-name=code_test
 * spring.data.cassandra.port=9042
 * spring.data.cassandra.contact-points=10.250.250.250
 */

/**
 * # api response codes
 * ResponseCode Description
 * 200          Successful indicator
 * <p>
 * Example Value;
 * {
 * "name": "Result",
 * "value": "Success"
 * }
 * <p>
 * 204 No Content
 * 400 Bad Request - please verify API
 * 401 Unauthorized
 * 403 Forbidden
 * 404 Profile not found
 * 500 Error while processing request
 */
public class Rest {
}
