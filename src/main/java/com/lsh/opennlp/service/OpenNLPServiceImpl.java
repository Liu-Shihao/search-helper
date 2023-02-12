package com.lsh.opennlp.service;

import opennlp.tools.tokenize.TokenizerME;
import opennlp.tools.tokenize.TokenizerModel;
import opennlp.tools.util.Span;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: LiuShihao
 * @Date: 2023/2/12 23:12
 * @Desc:
 */
@Service
public class OpenNLPServiceImpl implements OpenNLPService {

    @Autowired
    TokenizerModel tokenizerModel;
    @Override
    public void sentence(String sentence) {
        TokenizerME tokenizer = new TokenizerME(tokenizerModel);
        Span tokens[] = tokenizer.tokenizePos(sentence);
        double[] probs = tokenizer.getTokenProbabilities();
        for (Span token : tokens){
            System.out.println(token +" "+sentence.substring(token.getStart(), token.getEnd()));
        }
        for(int i = 0; i<probs.length; i++){
            System.out.println(probs[i]);
        }
    }
}
