package com.struts.file;

import com.opensymphony.xwork2.ActionContext;
import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import java.io.File;
import java.io.IOException;

public class FileUploadAction {
    private File image;
    private String imageFileName;

    public File getImage() {
        return image;
    }

    public void setImage(File image) {
        this.image = image;
    }

    public String getImageFileName() {
        return imageFileName;
    }

    public void setImageFileName(String imageFileName) {
        this.imageFileName = imageFileName;
    }

    public String addUi() {
        return "success";
    }

    public String execute() throws IOException {
        String realPath = ServletActionContext.getServletContext().getRealPath("/images");
        System.out.println(realPath);
        if (image != null) {
            File saveFile = new File(new File(realPath), imageFileName);
            if (!saveFile.getParentFile().exists()) {
                saveFile.getParentFile().mkdirs();
                FileUtils.copyFile(image, saveFile);
                ActionContext.getContext().put("message", "文件上传成功");
            }
        }
        return "success";
    }
}
