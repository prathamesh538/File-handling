# File-handling

*COMPANY*:CODTECH IT SOLUTIONS

*NAME*:PRATHAMESH SANJAY PATHARE

*INTERN ID*:CT08WPS

*DOMAIN*:JAVA PROGRAMMING

*DURATION*:4 WEEKS

*MENTOR*:NEELA SANTOSH KUMAR

### **Description of the File Handling Utility in Java**

The **FileHandlingUtility** Java program is designed to demonstrate fundamental file operations such as writing to a file, reading from a file, and modifying file contents. These operations are crucial in many real-world applications, such as logging, data persistence, and configuration management.

---

### **1. Overview of the Program**
The program consists of three main methods:
- `writeFile(String content)`: Writes a given string to a text file.
- `readFile()`: Reads and displays the content of the text file.
- `modifyFile(String oldWord, String newWord)`: Searches for a word in the file and replaces it with a new word.

The file used for these operations is named **"sample.txt"**. The program follows best practices by handling exceptions properly using **try-with-resources**, ensuring that file streams are closed automatically.

---

### **2. Detailed Explanation of Each Method**

#### **a. Writing to a File (`writeFile` Method)**
This method takes a string as input and writes it to the file. The **BufferedWriter** class is used to write text efficiently. 

```java
try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH))) {
    writer.write(content);
    System.out.println("File written successfully.");
}
```
- `new FileWriter(FILE_PATH)`: Creates a new file (if it doesn’t exist) or overwrites the existing file.
- `BufferedWriter` improves performance by reducing direct disk writes.
- A message is printed to indicate successful writing.

#### **b. Reading from a File (`readFile` Method)**
This method reads and displays the content of the file using **BufferedReader**.

```java
try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH))) {
    String line;
    while ((line = reader.readLine()) != null) {
        System.out.println(line);
    }
}
```
- **BufferedReader** reads the file line by line, improving efficiency.
- If the file does not exist or an error occurs, an exception is caught, preventing crashes.

#### **c. Modifying File Content (`modifyFile` Method)**
This method replaces a specific word in the file with another word.

```java
Path path = Paths.get(FILE_PATH);
List<String> lines = Files.readAllLines(path);
List<String> modifiedLines = new ArrayList<>();

for (String line : lines) {
    modifiedLines.add(line.replaceAll(oldWord, newWord));
}
Files.write(path, modifiedLines);
```
- The `Files.readAllLines(path)` method reads the entire file into a **List of Strings**.
- A loop iterates through each line and replaces occurrences of `oldWord` with `newWord`.
- The updated content is written back using `Files.write(path, modifiedLines)`.

---

### **3. Execution Flow**
1. The `writeFile()` method is called to create and populate **"sample.txt"**.
2. The `readFile()` method is called to display the file content.
3. The `modifyFile()` method replaces the word **"test"** with **"sample"**.
4. The `readFile()` method is called again to show the modified content.

---

### **4. Exception Handling**
The program includes proper exception handling:
- If the file does not exist, an error message is displayed instead of crashing.
- **try-with-resources** ensures resources are closed automatically.

---

### **Conclusion**
This Java program provides a simple yet powerful demonstration of file handling techniques, making it useful for logging, configuration, and text processing tasks.

*OUTPUT*
![image](https://github.com/user-attachments/assets/9983472a-3176-4fe9-8490-7b5003f3e15d)
