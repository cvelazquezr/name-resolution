import java.io.FileInputStream;
import java.util.zip.ZipOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.List;

public static File zip(List<File> files, String filename) {
File zipfile = new File(filename);
// Create a buffer for reading the files
byte[] buf = new byte[1024];
try {
// create the ZIP file
ZipOutputStream out = new ZipOutputStream(new FileOutputStream(zipfile));
// compress the files
for(int i=0; i<files.size(); i++) {
FileInputStream in = new FileInputStream(files.get(i).getCanonicalName());
// add ZIP entry to output stream
out.putNextEntry(new ZipEntry(files.get(i).getName()));
// transfer bytes from the file to the ZIP file
int len;
while((len = in.read(buf)) > 0) {
out.write(buf, 0, len);
}
// complete the entry
out.closeEntry();
in.close();
}
// complete the ZIP file
out.close();
return zipfile;
} catch (IOException ex) {
System.err.println(ex.getMessage());
}
return null;
}
