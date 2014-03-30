import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class CopiaFile_x_Byte {
	public static void main(String args[]) throws Exception{
		File fin=new File("img1.bmp");
		FileInputStream fis=new FileInputStream(fin);
		File fout=new File("img2.bmp");
		copyFile(fis,fout);
		System.out.println("Finito!");
	}
	
	
	public static void copyFile(InputStream pIn, File pOut) throws IOException {
        if (!pOut.exists()) {
            pOut.createNewFile();
        }
        DataInputStream dis = new DataInputStream(pIn);
        FileOutputStream fos = new FileOutputStream(pOut);
        byte[] bytes = new byte[1024];
        int len;
        while ((len = dis.read(bytes)) > 0) {
            fos.write(bytes, 0, len);
        }
        dis.close();
        fos.close();
    }
}