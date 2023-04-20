package FileDownloader;

class FileDownloader {
    interface Callback {
        void porcentaje (int percentage);
    }
    public void downloadFile(String filePath, Callback callback) {
        // simular progreso de descarga
        for (int percentage = 0; percentage <= 100; percentage += 10) {
            callback.porcentaje(percentage);

            try { Thread.sleep(1000); } catch (InterruptedException ignored) {}
        }
    }
}

public class Main {
    public static void main(String[] args) {
        FileDownloader fileDownloader = new FileDownloader();
        fileDownloader.downloadFile("http://.../myFile.txt", new FileDownloader.Callback() {
            @Override
            public void porcentaje(int percentage) {
                System.out.println("Loading: " + percentage + "%");
            }
        });
        fileDownloader.downloadFile("http://.../myFile.txt", new FileDownloader.Callback() {
            @Override
            public void porcentaje(int percentage) {
                System.out.println("Loading streaming: " + percentage + "%");
            }
        });
    }
}