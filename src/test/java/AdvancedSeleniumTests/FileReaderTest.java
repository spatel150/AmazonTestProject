package AdvancedSeleniumTests;

public class FileReaderTest {
   public static void main(String[] args) throws IOException {

        String excelFile = "src/test/test-files/SampleData.xlsx";

        FileInputStream inputStream = new FileInputStream(excelFile);
        Workbook workbook = new XSSFWorkbook(inputStream);

        Sheet sheet1 = workbook.getSheetAt(1);

        for (Row row : sheet1) {
            for (Cell cell : row) {
                String cellValue = "";
                if (cell.getCellType() == CellType.STRING) {
                    cellValue = cell.getStringCellValue();
                } else if (cell.getCellType() == CellType.NUMERIC) {
                    cellValue = String.valueOf(cell.getNumericCellValue());
                }
                System.out.print(cellValue + "\t");
            }
            System.out.println();
        }

        workbook.close();
        inputStream.close();
    }

}
