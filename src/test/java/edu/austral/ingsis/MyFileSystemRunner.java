package edu.austral.ingsis;

import edu.austral.ingsis.clifford.FileSystem;
import edu.austral.ingsis.clifford.MyFileSystem;
import edu.austral.ingsis.clifford.parsers.*;
import java.util.ArrayList;
import java.util.List;

public class MyFileSystemRunner implements FileSystemRunner {

  @Override
  public List<String> executeCommands(List<String> commands) {
    FileSystem fileSystem = new MyFileSystem();
    addCommands(fileSystem);
    List<String> results = new ArrayList<>();
    for (String command : commands) {
      String result = fileSystem.run(command);
      results.add(result);
    }
    return results;
  }

  private static void addCommands(FileSystem fileSystem) {
    fileSystem.addCommand("cd", new CdParser(fileSystem));
    fileSystem.addCommand("ls", new LsParser());
    fileSystem.addCommand("pwd", new PwdParser());
    fileSystem.addCommand("mkdir", new MkdirParser());
    fileSystem.addCommand("touch", new TouchParser());
    fileSystem.addCommand("rm", new RmParser(fileSystem));
  }
}
