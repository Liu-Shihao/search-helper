package com.lsh.opennlp;

import opennlp.tools.namefind.NameFinderME;
import opennlp.tools.namefind.TokenNameFinderModel;
import opennlp.tools.tokenize.TokenizerME;
import opennlp.tools.tokenize.TokenizerModel;
import opennlp.tools.util.Span;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;

/**
 * @Author: LiuShihao
 * @Date: 2023/2/12 22:41
 * @Desc:
 */
public class NameFinderTest {

    @Test
    public void test1() throws IOException {
        TokenNameFinderModel model = new TokenNameFinderModel(new File("bin/en-ner-person.bin"));
        NameFinderME nameFinder = new NameFinderME(model);
        String [] sentence = new String[]{
                "Mike",
                "and",
                "Smith",
                "are",
                "good",
                "friends",
                "zhangsan",
                "张三",
                "ZhangSan",
                "李四",
                "Joey",
                "Jack"
        };
        //Finding the names in the sentence
        Span nameSpans[] = nameFinder.find(sentence);

        //Printing the spans of the names in the sentence
        for(Span s: nameSpans){
            System.out.println(s.toString());
        }

    }


    @Test
    public void test2() throws IOException {
        TokenizerModel tokenModel = new TokenizerModel(new File("/Users/liushihao/Data/IdeaProjects/search-helper/bin/en-token.bin"));
        TokenizerME tokenizer = new TokenizerME(tokenModel);
        String sentence = "Mike is senior programming \n" +
                "        manager and Rama is a clerk both are working at\n" +
                "        Tutorialspoint";
        String tokens[] = tokenizer.tokenize(sentence);
        TokenNameFinderModel model = new TokenNameFinderModel(new File("/Users/liushihao/Data/IdeaProjects/search-helper/bin/en-ner-person.bin"));
        NameFinderME nameFinder = new NameFinderME(model);

        //Finding the names in the sentence
        Span nameSpans[] = nameFinder.find(tokens);

        for(Span s: nameSpans){
            System.out.println(s.toString()+"  "+tokens[s.getStart()]);
        }
    }

    @Test
    public void test3() throws IOException {
        TokenizerModel tokenModel = new TokenizerModel(new File("/Users/liushihao/Data/IdeaProjects/search-helper/bin/en-token.bin"));
        TokenizerME tokenizer = new TokenizerME(tokenModel);
        String paragraph = "Tutorialspoint is located in Hyderabad,Beijing,Shanghai,Zhengzhou,Tokyo";
        String tokens[] = tokenizer.tokenize(paragraph);

        TokenNameFinderModel model = new TokenNameFinderModel(new File("/Users/liushihao/Data/IdeaProjects/search-helper/bin/en-ner-location.bin"));

        NameFinderME nameFinder = new NameFinderME(model);

        //Finding the names of a location
        Span nameSpans[] = nameFinder.find(tokens);
        //Printing the spans of the locations in the sentence
        for(Span s: nameSpans){
            System.out.println(s.toString()+"  "+tokens[s.getStart()]);
        }
    }

}
