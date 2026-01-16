package herokuapp.pagestest;

import herokuapp.basetest.BaseTest;
import herokuapp.pages.FileUploadPage;
import herokuapp.pages.HomePage;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileWriter;

public class FileUploadTest extends BaseTest {

    @Test
    public void tc01_verifyFileUpload() throws Exception {
        HomePage home = new HomePage(driver);
        home.openModule("File Upload");

        File f = new File(System.getProperty("user.dir") + "/upload_sample.txt");
        try (FileWriter fw = new FileWriter(f)) {
            fw.write("sample upload");
        }

        FileUploadPage upload = new FileUploadPage(driver);
        upload.uploadFile(f.getAbsolutePath());

        Assert.assertEquals(upload.getUploadedHeading(), "File Uploaded!");
    }
}
