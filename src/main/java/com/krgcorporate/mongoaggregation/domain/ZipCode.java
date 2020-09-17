package com.krgcorporate.mongoaggregation.domain;

import com.fasterxml.jackson.annotation.JsonCreator;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NonNull;
import lombok.With;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.PersistenceConstructor;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.lang.Nullable;

import java.util.List;

@Document(collection = "zipcodes")
@Data
@Builder
@With
@AllArgsConstructor(access = AccessLevel.PACKAGE, onConstructor_ = {@JsonCreator, @PersistenceConstructor})
public class ZipCode {

    @Id
    private @Nullable String id;

    @Indexed
    private @NonNull String city;

    private @Nullable List<Double> loc;

    @Indexed
    private @NonNull String state;

    private @Nullable int pop;
}
