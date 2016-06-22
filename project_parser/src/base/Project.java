package base;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Класс Project отвечает за хранение проекта
 */

public class Project {

    private File projectPath;
    private List<Macroprogramm> macroprogramms = new ArrayList<>();


    public Project(String projectPath) {
        this.projectPath = new File(projectPath);
        if (this.projectPath.exists() && this.projectPath.isDirectory()) {
            initMacroprogramms();
        } else {
            macroprogramms = null;
        }
    }

    private void initMacroprogramms() {
        MacroprogrammFactory macroprogrammFactory = new MacroprogrammFactory();
        for (File macroprogramm : projectPath.listFiles()) {
            if (macroprogramm.isDirectory()) {
                Macroprogramm parsedMacroprogramm = macroprogrammFactory.createMacroprogramm(macroprogramm);
                if (parsedMacroprogramm != null) {
                    macroprogramms.add(macroprogrammFactory.createMacroprogramm(macroprogramm));
                    parsedMacroprogramm.parse();
                }
            }
        }
    }

    /**
     * Метод возвращает директорию с проектом
     * если данной директории не существует, то возвращается <code>null</code>
     *
     * @return Директория с проектом или <code>null</code>
     */

    public File getProjectPath() {
        return projectPath.exists() && projectPath.isDirectory() ? projectPath : null;
    }

    /**
     * Метод возвращает имя проекта (имя директории)
     * если такой директории нет, возвращается <code>null</code>
     *
     * @return Имя проекта или <code>null</code>
     */
    public String getName() {
        if (getProjectPath() != null) {
            return projectPath.getName();
        }
        return null;
    }
}
