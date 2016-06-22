package base;

import java.io.File;

/**
 * Класс Macroprogramm предназначен для хранения макропрограмм
 * Используется для наследования
 *
 * @see dkd.Dkd
 * @see foti.Foti
 * @see seans.Seans
 */
public abstract class Macroprogramm {

    protected static final String MACROPROGRAMM_ROUTE = "IS_DN";
    protected File mpPath;

    public Macroprogramm(String mpPath) {
        this.mpPath = new File(mpPath);
    }

    @Override
    public String toString() {
        return mpPath.getName();
    }

    /**
     * Абстрактный метод для генерации макропрограммы.
     */
    public abstract void parse();
}
