package br.edu.ifpb.main;

public class Converter {

	// Converte caracteres para seu valor em byte (0..255)
	public static int[] getValues(String s) {
		
		byte[] bytes = s.getBytes();
		int[] values = new int[bytes.length];
		
		for(int i=0; i<bytes.length; i++) {
			values[i] = (int) bytes[i];
		}
		
		return values;
	}
	
	public static String toString(int[] values) {
		
		byte[] bytes = new byte[values.length];
		
		for(int i=0; i<bytes.length; i++) {
			bytes[i] = (byte) values[i];
		}
		
		return new String(bytes);
	}
	
}
