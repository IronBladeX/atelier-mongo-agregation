package com.krgcorporate.mongoaggregation.repotisory;

import com.krgcorporate.mongoaggregation.domain.ZipCode;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ZipCodeRepository extends MongoRepository<ZipCode, String> {

    List<ZipCode> findAll();
}
