package br.edu.ifpb.main;

public class Main {
	
	public static void main(String[] args) {
		
		int[] key = Converter.getValues("KEY");
		int[] text = Converter.getValues("HELLO WORLD!");
		
		int[] encrypted = RC4.encrypt(text, key);
		int[] decrypted = RC4.decrypt(encrypted, key);
		
		System.out.println("Valor numerico da chave:");
		printArray(key);
		
		System.out.println("Valor numerico do texto:");
		printArray(text);
		
		System.out.println("Valor numerico do resultado da cifragem:");
		printArray(encrypted);
		
		System.out.println("Valor numerico do resultado da decifragem:");
		printArray(decrypted);
		
		System.out.println("Convertendo valores decifrados para String:");
		System.out.println(Converter.toString(decrypted));
	}
	
	private static void printArray(int[] array) {
		for(int i: array) {
			System.out.print(i+" ");
		}
		System.out.println();
		System.out.println();
	}
	
}
