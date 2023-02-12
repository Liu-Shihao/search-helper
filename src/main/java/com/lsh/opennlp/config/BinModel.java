package com.lsh.opennlp.config;

import opennlp.tools.namefind.TokenNameFinderModel;
import opennlp.tools.parser.ParserModel;
import opennlp.tools.sentdetect.SentenceModel;
import opennlp.tools.tokenize.TokenizerModel;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;

/**
 * @Author: LiuShihao
 * @Date: 2023/2/12 23:01
 * @Desc:
 */
@Component
public class BinModel {

    @Bean
    public SentenceModel sentenceModel() throws IOException {
        SentenceModel sentenceModel = new SentenceModel(new File("bin/en-sent.bin"));
        return sentenceModel;
    }
    @Bean
    public ParserModel parserModel() throws IOException {
        ParserModel parserModel = new ParserModel(new File("bin/en-parser-chunking.bin"));
        return parserModel;
    }
    @Bean
    public TokenizerModel tokenizerModel() throws IOException {
        TokenizerModel tokenizerModel = new TokenizerModel(new File("bin/en-token.bin"));
        return tokenizerModel;
    }

    @Bean("personNameFinderModel")
    public TokenNameFinderModel personNameFinderModel() throws IOException {
        TokenNameFinderModel personNameFinderModel = new TokenNameFinderModel(new File("bin/en-ner-person.bin"));
        return personNameFinderModel;
    }

    @Bean("locationNameFinderModel")
    public TokenNameFinderModel locationNameFinderModel  () throws IOException {
        TokenNameFinderModel locationNameFinderModel = new TokenNameFinderModel(new File("bin/en-ner-location.bin"));
        return locationNameFinderModel;
    }
    @Bean("organizationNameFinderModel")
    public TokenNameFinderModel organizationNameFinderModel  () throws IOException {
        TokenNameFinderModel organizationNameFinderModel = new TokenNameFinderModel(new File("bin/en-ner-organization.bin"));
        return organizationNameFinderModel;
    }
    @Bean("moneyNameFinderModel")
    public TokenNameFinderModel moneyNameFinderModel  () throws IOException {
        TokenNameFinderModel moneyNameFinderModel = new TokenNameFinderModel(new File("bin/en-ner-money.bin"));
        return moneyNameFinderModel;
    }
    @Bean("dateNameFinderModel")
    public TokenNameFinderModel dateNameFinderModel  () throws IOException {
        TokenNameFinderModel dateNameFinderModel = new TokenNameFinderModel(new File("bin/en-ner-date.bin"));
        return dateNameFinderModel;
    }
    @Bean("timeNameFinderModel")
    public TokenNameFinderModel timeNameFinderModel  () throws IOException {
        TokenNameFinderModel timeNameFinderModel = new TokenNameFinderModel(new File("bin/en-ner-time.bin"));
        return timeNameFinderModel;
    }

}
