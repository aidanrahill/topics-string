import java.io.*;

class ReadWriteString {
    public String ReadFile(String fileName) {
        StringBuilder content = new StringBuilder();

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                content.append(line).append("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return content.toString();
    }

    public void WriteString(String string, String fileName) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            writer.write(string);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public int countChar(String fileName) throws IOException {
        int count = 0;
        File file = new File(fileName);
        BufferedReader br = new BufferedReader(new FileReader(file));
        while (br.ready()) {
            br.read();
            count++;
        }
        return count;
    }

    public static void main(String[] args) throws IOException {
        ReadWriteString fileHandler = new ReadWriteString();

        // Reading from a file
        String fileNameToRead = "input.txt";
        String contentRead = fileHandler.ReadFile(fileNameToRead);
        System.out.println("Content read from file:\n" + contentRead);

        // Writing to a file
        String contentToWrite = "Hello, this is content to be written!";
        String fileNameToWrite = "output.txt";
        fileHandler.WriteString(contentToWrite, fileNameToWrite);
        System.out.println("Content written to file.");

        // Counting from a file
        String fileName = "output.txt";
        System.out.println(fileHandler.countChar("output.txt"));
    }
}