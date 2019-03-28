package Blockchain;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class Main {

    public static void main(String[] args) throws IOException {
		URL cripto = new URL ("https://min-api.cryptocompare.com/data/pricemulti?fsyms=BTC&tsyms=USD,EUR");
		URLConnection criptovalu = cripto.openConnection();
		System.out.println("VALUTA BTC:"); 
		try(BufferedReader in=new BufferedReader(new InputStreamReader(criptovalu.getInputStream()))){
			String jsonstring;
			while((jsonstring = in.readLine())!=null) { 
			      System.out.println(jsonstring);
			}
		}
        String[] genesisTransactions = {"Danilo ha inviato 1 Bitcoin a Marco","Danilo ha inviato 3 Bitcoin a Maria"};
        Block genesisBlock = new Block(genesisTransactions);

        String[] block2Transactions = {"Matteo ha inviato 10 Bitcoin a Marcello", "Giulia ha inviato 1 bitcoin a Alessio"};
        Block block2 = new Block(genesisBlock.getHash(), block2Transactions);

        System.out.println("Hash del blocco di genesi:");
        System.out.println(genesisBlock.getHash());

        System.out.println("Hash del blocco 2:");
        System.out.println(block2.getHash());

    }


}
