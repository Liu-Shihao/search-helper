package com.lsh.opennlp;

import opennlp.tools.sentdetect.SentenceDetectorME;
import opennlp.tools.sentdetect.SentenceModel;
import opennlp.tools.util.Span;
import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/**
 * @Author: LiuShihao
 * @Date: 2023/2/12 20:54
 * @Desc: 句子检测
 */
public class SentenceModelTest {

    @Test
    public void test(){
        String sentence = " Hi. How are you? Welcome to Tutorialspoint. "
                + "We provide free tutorials on various technologies";

        String simple = "[.?!]";
        String[] splitString = (sentence.split(simple));
        for (String string : splitString)
            System.out.println(string);
    }

    /**
     * 检测句子
     * @throws IOException
     */
    @Test
    public void test2() throws IOException {
//        String sentence = " Hi. How are you? Welcome to Tutorialspoint. "
//                + "We provide free tutorials on various technologies";
        String sentence = "NLP是自然语言处理的缩写，是计算机科学领域中一种研究如何让计算机理解人类语言的技术。它包括语音识别、语音合成、词法分析、句法分析、语义分析、情感分析等多个方面。要使用NLP技术，您需要学习相关的知识和技巧，并使用适当的NLP工具包。在Java语言中，您可以使用OpenNLP、Stanford NLP、DeepNLP等NLP工具包，它们都是用Java编写的，易于使用。除了使用已有的NLP工具包，您也可以自己开发NLP算法，以实现自定义的NLP功能。希望这些信息对您有所帮助！";

        //Loading sentence detector model
        InputStream inputStream = new FileInputStream("/Users/liushihao/Data/IdeaProjects/search-helper/bin/en-sent.bin");
        SentenceModel model = new SentenceModel(inputStream);
        //Instantiating the SentenceDetectorME class
        SentenceDetectorME detector = new SentenceDetectorME(model);
        //Detecting the sentence
        String sentences[] = detector.sentDetect(sentence);
        //Printing the sentences
        for(String sent : sentences)
            System.out.println(sent);
    }

    /**
     * 句子及其位置
     * @throws IOException
     */
    @Test
    public void test3() throws IOException {
        String paragraph = "Hi. How are you? Welcome to Tutorialspoint. "
                + "We provide free tutorials on various technologies";

        //Loading sentence detector model
        InputStream inputStream = new FileInputStream("/Users/liushihao/Data/IdeaProjects/search-helper/bin/en-sent.bin");
        SentenceModel model = new SentenceModel(inputStream);

        //Instantiating the SentenceDetectorME class
        SentenceDetectorME detector = new SentenceDetectorME(model);

        //Detecting the position of the sentences in the raw text
        Span spans[] = detector.sentPosDetect(paragraph);

        //Printing the spans of the sentences in the paragraph
        for (Span span : spans){
//            System.out.println(span);
            //读取给定的字符string并检测句子及其位置
            System.out.println(paragraph.substring(span.getStart(), span.getEnd())+" "+ span);
        }

    }


    /**
     * 句子概率检测
     * SentenceDetectorME类的getSentenceProbabilities（）方法返回与最近调用sentDetect（）方法相关联的概率。
     * @throws IOException
     */
    @Test
    public void test4() throws IOException {
        String sentence = "Hi. How are you? Welcome to Tutorialspoint. "
                + "We provide free tutorials on various technologies";

        //Loading sentence detector model
        InputStream inputStream = new FileInputStream("/Users/liushihao/Data/IdeaProjects/search-helper/bin/en-sent.bin");
        SentenceModel model = new SentenceModel(inputStream);

        //Instantiating the SentenceDetectorME class
        SentenceDetectorME detector = new SentenceDetectorME(model);

        //Detecting the sentence
        String sentences[] = detector.sentDetect(sentence);

        //Printing the sentences
        for(String sent : sentences)
            System.out.println(sent);

        //Getting the probabilities of the last decoded sequence
        double[] probs = detector.getSentenceProbabilities();

        System.out.println("  ");

        for(int i = 0; i<probs.length; i++){
            System.out.println(probs[i]);
        }

    }




}
