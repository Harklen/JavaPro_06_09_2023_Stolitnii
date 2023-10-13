import java.util.*;
import java.util.stream.Collectors;

class FileData {
    String name;
    long size;
    String path;

    public FileData(String name, long size, String path) {
        this.name = name;
        this.size = size;
        this.path = path;
    }
}

class FileNavigator {
    private Map<String, List<FileData>> fileMap = new HashMap<>();

    public void add(FileData fileData) {
        String pathKey = getPathKey(fileData.path);

        if (!fileMap.containsKey(pathKey)) {
            System.out.println("Помилка: Шлях-ключ не співпадає з шляхом до файлу.");
            return;
        }

        fileMap.get(pathKey).add(fileData);
    }

    public List<FileData> find(String path) {
        String pathKey = getPathKey(path);
        return fileMap.getOrDefault(pathKey, Collections.emptyList());
    }

    public List<FileData> filterBySize(long maxSize) {
        return fileMap.values()
                .stream()
                .flatMap(Collection::stream)
                .filter(fileData -> fileData.size <= maxSize)
                .collect(Collectors.toList());
    }

    public void remove(String path) {
        String pathKey = getPathKey(path);
        fileMap.remove(pathKey);
    }

    public List<FileData> sortBySize() {
        List<FileData> allFiles = fileMap.values()
                .stream()
                .flatMap(Collection::stream)
                .collect(Collectors.toList());

        allFiles.sort(Comparator.comparingLong(fileData -> fileData.size));

        return allFiles;
    }

    private String getPathKey(String path) {
        return path;
    }

    public static void main(String[] args) {
        FileNavigator fileNavigator = new FileNavigator();

        FileData file1 = new FileData("file1.txt", 100, "/path/to/file");
        FileData file2 = new FileData("file2.txt", 200, "/path/to/file");
        FileData file3 = new FileData("file3.txt", 50, "/another/path");

        fileNavigator.add(file1);
        fileNavigator.add(file2);
        fileNavigator.add(file3);

        System.out.println("Файли по шляху '/path/to/file': " + fileNavigator.find("/path/to/file"));
        System.out.println("Файли розміром не більше 150 байт: " + fileNavigator.filterBySize(150));
        fileNavigator.remove("/path/to/file");
        System.out.println("Файли після видалення шляху '/path/to/file': " + fileNavigator.find("/path/to/file"));
        System.out.println("Файли, відсортовані за розміром: " + fileNavigator.sortBySize());
    }
}
