package com.lsh.opennlp;

import opennlp.tools.cmdline.parser.ParserTool;
import opennlp.tools.parser.Parse;
import opennlp.tools.parser.Parser;
import opennlp.tools.parser.ParserFactory;
import opennlp.tools.parser.ParserModel;
import opennlp.tools.tokenize.TokenizerME;
import opennlp.tools.tokenize.TokenizerModel;
import opennlp.tools.util.Span;
import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * @Author: LiuShihao
 * @Date: 2023/2/12 22:25
 * @Desc:
 */
public class SimpleTokenizerTest {

    /**
     * 读取给定的字符string，并对句子进行标记并打印。此外，它还返回与最近调用的tokenizerPos（）方法相关联的概率。
     * @throws IOException
     */
    @Test
    public void test1() throws IOException {
        String sentence = "Hello John how are you welcome to Tutorialspoint";
        //Loading sentence detector model
        InputStream inputStream = new FileInputStream("/Users/liushihao/Data/IdeaProjects/search-helper/bin/en-token.bin");
        TokenizerModel tokenModel = new TokenizerModel(inputStream);

        //Instantiating the TokenizerME class
        TokenizerME tokenizer = new TokenizerME(tokenModel);

        //Tokenizing the given raw text
        Span tokens[] = tokenizer.tokenizePos(sentence);

        //Getting the probabilities of the recent calls to tokenizePos() method
        double[] probs = tokenizer.getTokenProbabilities();

        //Printing the tokens
        for (Span token : tokens){
            System.out.println(token +" "+sentence.substring(token.getStart(), token.getEnd()));
        }
        for(int i = 0; i<probs.length; i++){
            System.out.println(probs[i]);
        }

    }
}
