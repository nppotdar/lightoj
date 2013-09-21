package graphtheory.bfsdfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class InputReader {
	public BufferedReader reader;
	public StringTokenizer tokenizer;

	public InputReader(InputStream stream) {
		reader = new BufferedReader(new InputStreamReader(stream));
		tokenizer = null;
	}

	public String next() {
		while (tokenizer == null || !tokenizer.hasMoreTokens()) {
			try {
				tokenizer = new StringTokenizer(reader.readLine());
			} catch (IOException e) {
				throw new RuntimeException(e);
			}
		}
		return tokenizer.nextToken();
	}

	public int nextInt() {
		return Integer.parseInt(next());
	}
	
	public String nextLine() {
		try {
			tokenizer = new StringTokenizer(reader.readLine(), "\n");
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
		return tokenizer.nextToken();
	}
	public void readBlankLine(){
		try {
			tokenizer = new StringTokenizer(reader.readLine(), "\n");
		} catch (IOException e) {
			return; 
		}
	}

}