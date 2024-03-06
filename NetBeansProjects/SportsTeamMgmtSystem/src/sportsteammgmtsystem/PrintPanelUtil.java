package sportsteammgmtsystem;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;

import javax.swing.JPanel;

public class PrintPanelUtil {

    public static void printComponent(JPanel componentToBePrinted) {
        PrinterJob printJob = PrinterJob.getPrinterJob();
        printJob.setPrintable(new ComponentPrintable(componentToBePrinted));

        if (printJob.printDialog()) {
            try {
                printJob.print();
            } catch (PrinterException pe) {
                System.out.println("Error printing: " + pe);
            }
        }
    }

    private static class ComponentPrintable implements Printable {

        private final JPanel componentToBePrinted;

        public ComponentPrintable(JPanel componentToBePrinted) {
            this.componentToBePrinted = componentToBePrinted;
        }

        @Override
        public int print(Graphics graphics, PageFormat pageFormat, int pageIndex) throws PrinterException {
            if (pageIndex > 0) {
                return NO_SUCH_PAGE;
            }

            Graphics2D g2 = (Graphics2D) graphics;
            g2.translate(pageFormat.getImageableX(), pageFormat.getImageableY());
            componentToBePrinted.print(g2);
            return PAGE_EXISTS;
        }
    }
}

