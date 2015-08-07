package net.cosmo.spring.view;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import net.cosmo.spring.model.Book;

import org.supercsv.io.ICsvBeanWriter;

public class CsvViewImpl extends AbstractCsvView {

	@SuppressWarnings("unchecked")
	protected void buildCsvDocument(ICsvBeanWriter csvWriter, Map<String, Object> model) throws IOException {
		List<Book> bookList = (List<Book>) model.get("csvData");
		String[] header = (String[]) model.get("csvHeader");

		csvWriter.writeHeader(header);
		for (Book book : bookList) {
			csvWriter.write(book, header);
		}
	}

}
