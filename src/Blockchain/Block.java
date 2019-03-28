package Blockchain;

import java.nio.charset.StandardCharsets;
import java.util.Date;

import com.google.common.hash.Hashing;

public class Block {
	
	private int versione;
	private String hash;
	private String previousHash; //hash del blocco precedente
	private String merkleRoot; // hash di tutti gli hash delle transazioni
	private String[] transazioni;
	private long timeStamp; //numero in millisecondi dal 1/1/1970.
	private int nonce;
	
	public Block(String[] transazioni) {
		this.previousHash = "0";
		this.setTransazioni(transazioni);
		this.setMerkleRoot(calcolamerkle());
		this.setTimeStamp(new Date().getTime());
		this.setHash(calcolaHash());
	}
	

	public Block(String previousHash , String[] transazioni) {
		this.previousHash = previousHash;
		this.setTransazioni(transazioni);
		this.setMerkleRoot(calcolamerkle());
		this.setTimeStamp(new Date().getTime());
		this.setHash(calcolaHash());
	}
	
	public String calcolamerkle() {
		String merkleroot = Hashing.sha256()
				  .hashString(getTransazioni().toString(), StandardCharsets.UTF_8)
				.toString();
	return merkleroot;
}
	
	public String calcolaHash() {
		String calcolahash = Hashing.sha256()
				  .hashString((	previousHash +
				Long.toString(getTimeStamp()) +
				Integer.toString(getNonce()) +
				getMerkleRoot() +
				getTransazioni()), StandardCharsets.UTF_8)
				.toString();
		return calcolahash;
	}


	public String getHash() {
		return hash;
	}

	public void setHash(String hash) {
		this.hash = hash;
	}


	public int getVersione() {
		return getpreviousHash();
	}


	public void setVersione(int versione) {
		this.setpreviousHash(versione);
	}


	public int getpreviousHash() {
		return versione;
	}


	public void setpreviousHash(int versione) {
		this.versione = versione;
	}


	public String getMerkleRoot() {
		return merkleRoot;
	}


	public void setMerkleRoot(String merkleRoot) {
		this.merkleRoot = merkleRoot;
	}


	public String[] getTransazioni() {
		return transazioni;
	}


	public void setTransazioni(String[] transazioni) {
		this.transazioni = transazioni;
	}


	public long getTimeStamp() {
		return timeStamp;
	}


	public void setTimeStamp(long timeStamp) {
		this.timeStamp = timeStamp;
	}


	public int getNonce() {
		return nonce;
	}


	public void setNonce(int nonce) {
		this.nonce = nonce;
	}
	
}
