package libs.arilibfx.updater;

import java.io.File;

/**
 * Created by Arinonia on 02/07/2020 inside the package - libs.arilibfx.updater
 */
public record DownloadManager(String url, DownloadJob job, File file) {

    public String getUrl() {

        return url;
    }

    public DownloadJob getJob() {

        return job;
    }

    public File getFile() {

        return file;
    }
}