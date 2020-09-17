package com.krgcorporate.mongoaggregation.ws;

import com.krgcorporate.mongoaggregation.business.ZipCodeManager;
import com.krgcorporate.mongoaggregation.domain.ZipCode;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.NonNull;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/zip-code")
@AllArgsConstructor(access = AccessLevel.PACKAGE, onConstructor_ = @Autowired)
public class ZipCodeController {

    private final @NonNull ZipCodeManager zipCodeManager;

    @GetMapping("intro")
    public List<Document> intro() {
        return zipCodeManager.intro();
    }

    @GetMapping("exe1")
    public List<ZipCode> exe1() {
        return zipCodeManager.exe1();
    }

    @GetMapping("exe2")
    public List<ZipCode> exe2() {
        return zipCodeManager.exe2();
    }

    @GetMapping("exe3")
    public List<ZipCode> exe3() {
        return zipCodeManager.exe3();
    }

    @GetMapping("exe4")
    public List<Document> exe4() {
        return zipCodeManager.exe4();
    }

    @GetMapping("exe5")
    public List<Document> exe5() {
        return zipCodeManager.exe5();
    }

    @GetMapping("exe6")
    public List<Document> exe6() {
        return zipCodeManager.exe6();
    }

    @GetMapping("exe7")
    public List<Document> exe7() {
        return zipCodeManager.exe7();
    }

    @GetMapping("exe8")
    public List<Document> exe8() {
        return zipCodeManager.exe8();
    }
}
