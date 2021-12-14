package com.bdd.fileReaderManager;

import com.bdd.dataprovider.ConfigFileReader;

public class FileReaderManager {
	private static FileReaderManager filereadmanager;
	private static ConfigFileReader configfilereader;

	public static FileReaderManager getFileReaderManagerInstance() {
		return (filereadmanager == null) ? new FileReaderManager() : filereadmanager;
	}

	public ConfigFileReader getConfigInstance() {
		return (configfilereader == null) ? new ConfigFileReader() : configfilereader;
	}
}