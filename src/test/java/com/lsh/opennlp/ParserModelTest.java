package com.lsh.opennlp;

import opennlp.tools.cmdline.parser.ParserTool;
import opennlp.tools.parser.Parse;
import opennlp.tools.parser.Parser;
import opennlp.tools.parser.ParserFactory;
import opennlp.tools.parser.ParserModel;
import opennlp.tools.sentdetect.SentenceModel;
import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * @Author: LiuShihao
 * @Date: 2023/2/12 22:21
 * @Desc: 句子分析
 */
public class ParserModelTest {

    @Test
    public void test1() throws IOException {
        String sentence = "NLP是自然语言处理的缩写，是计算机科学领域中一种研究如何让计算机理解人类语言的技术。它包括语音识别、语音合成、词法分析、句法分析、语义分析、情感分析等多个方面。要使用NLP技术，您需要学习相关的知识和技巧，并使用适当的NLP工具包。在Java语言中，您可以使用OpenNLP、Stanford NLP、DeepNLP等NLP工具包，它们都是用Java编写的，易于使用。除了使用已有的NLP工具包，您也可以自己开发NLP算法，以实现自定义的NLP功能。希望这些信息对您有所帮助！";

        //Loading sentence detector model
        InputStream inputStream = new FileInputStream("/Users/liushihao/Data/IdeaProjects/search-helper/bin/en-parser-chunking.bin");
        ParserModel model = new ParserModel(inputStream);

        //Creating a parser
        Parser parser = ParserFactory.create(model);
        Parse topParses[] = ParserTool.parseLine(sentence, parser, 1);
        for (Parse p : topParses){
            p.show();
        }


    }
}
