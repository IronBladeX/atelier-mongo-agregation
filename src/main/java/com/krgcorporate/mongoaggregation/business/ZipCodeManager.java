package com.krgcorporate.mongoaggregation.business;

import com.krgcorporate.mongoaggregation.domain.ZipCode;
import com.krgcorporate.mongoaggregation.repotisory.ZipCodeRepository;
import com.mongodb.client.model.Aggregates;
import com.mongodb.client.model.Projections;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.AggregationOperation;
import org.springframework.data.mongodb.core.aggregation.AggregationResults;
import org.springframework.data.mongodb.core.aggregation.Fields;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.stereotype.Service;

import javax.print.Doc;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
@AllArgsConstructor(access = AccessLevel.PACKAGE, onConstructor_ = @Autowired)
public class ZipCodeManager {

    private final @NonNull MongoTemplate mongoTemplate;

    private final @NonNull ZipCodeRepository zipCodeRepository;

    public List<ZipCode> findAll() {
        return zipCodeRepository.findAll();
    }

    public List<Document> intro() {
        List<AggregationOperation> list = new ArrayList<>();

        list.add(Aggregation.match(Criteria.where("state").is("NV")));
        list.add(
                Aggregation.group(
                        Fields.from(
                                Fields.field("$id", "$state")
                        )
                )
                .sum("$pop").as("totalPop")
        );

        Aggregation agg = Aggregation.newAggregation(list);
        AggregationResults<Document> groupResults
                = mongoTemplate.aggregate(agg, ZipCode.class, Document.class);

        return groupResults.getMappedResults();
    }

    /*
        Reproduce Aggregation:

        db.getCollection("zipcodes").aggregate( [
           { $match: { state: "MA" } }
        ] );
     */
    public List<ZipCode> exe1() {
        // ToDo

        return new ArrayList<>();
    }

    /*
        Reproduce Aggregation:

        db.getCollection("zipcodes").aggregate( [
           { $match: { pop: { $gt: 100000 } } }
        ] );
     */
    public List<ZipCode> exe2() {
        // ToDo

        return new ArrayList<>();
    }

    /*
        Reproduce Aggregation:

        db.getCollection("zipcodes").aggregate( [
           { $match: { pop: { $gt: 50000 } } },
           { $sort: { pop: -1 } }
        ] );
     */
    public List<ZipCode> exe3() {
        // ToDo

        return new ArrayList<>();
    }

    /*
        Reproduce Aggregation:

        db.getCollection("zipcodes").aggregate( [
           { $group: { _id: { state: "$state", city: "$city" }, pop: { $sum: "$pop" } } }
        ] );
     */
    public List<Document> exe4() {
        // ToDo

        return new ArrayList<>();
    }

    /*
        Reproduce Aggregation:

        db.zipcodes.aggregate( [
           { $group: { _id: { state: "$state", city: "$city" }, pop: { $sum: "$pop" } } },
           { $group: { _id: "$_id.state", avgCityPop: { $avg: "$pop" } } }
        ] )
     */
    public List<Document> exe5() {
        // ToDo

        return new ArrayList<>();
    }

    /*
        Reproduce Aggregation:

        db.getCollection("zipcodes").aggregate( [
           { $group:
              {
                _id: { state: "$state", city: "$city" },
                pop: { $sum: "$pop" }
              }
           },
           { $sort: { pop: 1 } },
           { $group:
              {
                _id : "$_id.state",
                biggestCity:  { $last: "$_id.city" },
                biggestPop:   { $last: "$pop" },
                smallestCity: { $first: "$_id.city" },
                smallestPop:  { $first: "$pop" }
              }
           }
        ] );
     */
    public List<Document> exe6() {
        // ToDo

        return new ArrayList<>();
    }

    /*
        Reproduce Aggregation:

        db.getCollection("zipcodes").aggregate( [
          { $group:
              {
                _id: "$state",
                cities: { $addToSet: "$city" }
              }
           }
        ] );
     */
    public List<Document> exe7() {
        // ToDo

        return new ArrayList<>();
    }

    /*
        Reproduce Aggregation:

        db.getCollection("zipcodes").aggregate( [
          { $group:
              {
                _id: { state: "$state", city: "$city" },
                pop: { $sum: "$pop" }
              }
           },
           { $sort: { pop: 1 } },
           { $group:
              {
                _id : "$_id.state",
                biggestCity:  { $last: "$_id.city" },
                biggestPop:   { $last: "$pop" },
                smallestCity: { $first: "$_id.city" },
                smallestPop:  { $first: "$pop" }
              }
           },
          { $project:
            { _id: 0,
              state: "$_id",
              biggestCity:  { name: "$biggestCity",  pop: "$biggestPop" },
              smallestCity: { name: "$smallestCity", pop: "$smallestPop" }
            }
          }
        ] );
     */
    public List<Document> exe8() {

        return new ArrayList<>();
    }
}
