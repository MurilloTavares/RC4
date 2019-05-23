package br.edu.ifpb.main;

public class RC4 {

	public static int[] encrypt(int[] plaintext, int[] key) {
		
		int[] ksa = getKeyScheduling(key); // Gerando o KeyScheduling
		int[] prga = getPRGA(plaintext, ksa); // Fazendo permutacao
		
		// Fazendo XOR entre permutacao e o texto
		int[] result = new int[plaintext.length];
		for(int i=0; i<result.length; i++) {
			result[i] = plaintext[i] ^ prga[i];
		}
		return result;
	}
	
	public static int[] decrypt(int[] encrypted, int[] key) {
		return encrypt(encrypted, key); // Encriptando novamente retorna o texto original
	}
	
	private static int[] getKeyScheduling(int[] key) {
		
		// Inicializando o array s[] com os valores de 0..255
		int s[] = new int[256];
		for(int i=0; i<256; i++) {
			s[i] = i;
		}
				
		int j = 0;
		for(int i=0; i<256; i++) {
			
			j = (j + s[i] + key[i % key.length]) % 256;
						
			// swap s[i], s[j]
			int temp = s[i];
			s[i] = s[j];
			s[j] = temp;
		}
		
		return s;
	}
	
	private static int[] getPRGA (int[] text, int[] ksa) {
		
		int i = 0;
		int j = 0;
		
		int[] result = new int[text.length];
		
		for(int p=0; p<result.length; p++) {
			
			i = (i + 1) % 256;
			j = (j + ksa[i]) % 256;
			
			// swap ksa[i], ksa[j]
			int temp = ksa[i];
			ksa[i] = ksa[j];
			ksa[j] = temp;
			
			int k = ksa[(ksa[i] + ksa[j]) % 256];
			
			result[p] = k;
		}
		
		return result;
	}
	
	
	
}
