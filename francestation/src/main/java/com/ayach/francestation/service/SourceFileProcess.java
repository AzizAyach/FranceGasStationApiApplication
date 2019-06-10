package com.ayach.francestation.service;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardWatchEventKinds;
import java.nio.file.WatchEvent;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;
import java.util.Calendar;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import org.apache.commons.io.FilenameUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.ayach.francesstation.utility.Constants;
import com.ayach.francestation.xml.entity.Pdv_liste;

@Service
public class SourceFileProcess {

	private static final Logger logger = LoggerFactory.getLogger(SourceFileProcess.class);

	@Autowired
	private StationService stationService;

	@Async("threadPoolTaskExecutor")
	public void getProcessFileAndPreInsert() throws IOException, InterruptedException, JAXBException {

		WatchService watchService

				= FileSystems.getDefault().newWatchService();

		Path path = Paths.get(Constants.PATH_FILE);

		path.register(

				watchService,

				StandardWatchEventKinds.ENTRY_CREATE);

		WatchKey key;

		while ((key = watchService.take()) != null) {

			for (WatchEvent<?> event : key.pollEvents()) {

				logger.info(

						"Event kind:" + event.kind()

								+ ". File affected: " + event.context() + ".");

				StringBuilder stringBuilder = new StringBuilder();

				stringBuilder.append(Constants.PATH_FILE);

				stringBuilder.append("/");

				stringBuilder.append(event.context());
				getFileAndParsed(stringBuilder.toString());

			}

			key.reset();
		}

	}

	private void getFileAndParsed(final String relativePath) throws IOException, JAXBException {
		File file = new File(relativePath);
		if (FilenameUtils.getExtension(relativePath).equals("xml")) {
			Long startTime = Calendar.getInstance().getTimeInMillis();
			JAXBContext jaxbContext = JAXBContext.newInstance(Pdv_liste.class);
			Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
			Pdv_liste pdvlist = (Pdv_liste) jaxbUnmarshaller.unmarshal(file);
			Long endTime = Calendar.getInstance().getTimeInMillis();
			logger.info(endTime - startTime + ".ms for pdv size:" + pdvlist.getPdv().size());
			stationService.insertAndUpdateStation(pdvlist);
			pdvlist.getPdv().clear();
		}
		
		

	}
	
	

}
