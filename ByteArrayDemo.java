public class ByteArrayDemo {
	public static void main(String[] args) throws Exception {
	String info = "helloworld";
	InputStream input = new ByteArrayInputStream(info.getBytes());
	OutputStream output = new ByteArrayOutputStream();
	int temp = 0;
	while ((temp = input.read()) != -1) {
	output.write(Character.toUpperCase((char) temp));
	}
	String str = output.toString(); // ȡ������
	input.close() ;//�ر�??
	output.close() ;//?Ч
	System.out.println(str) ;
	}
	}