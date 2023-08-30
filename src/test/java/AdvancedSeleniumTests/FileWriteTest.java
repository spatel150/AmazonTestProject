package AdvancedSeleniumTests;

public class FileWriteTest {
   public static void main(String[] args) throws IOException {
        String path = "src/test/test-files/SampleData.xlsx";
        FileInputStream fs = new FileInputStream(path);
        Workbook wb = new XSSFWorkbook(fs);
        Sheet sheet1 = wb.getSheetAt(1);
        int lastRow = sheet1.getLastRowNum();
        for (int i = 0; i <= lastRow; i++) {
            Row row = sheet1.getRow(i);
            Cell cell = row.createCell(2);
            cell.setCellValue("99.99");
        }

        FileOutputStream fos = new FileOutputStream(path);
        wb.write(fos);
        fos.close();
    }
}
