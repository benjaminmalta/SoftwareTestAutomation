package apidemo.stups;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import apidemo.DataLayer;

public class JsonStubs extends DataLayer {

	private Path path;

	public JsonStubs(String jsonFile) {
		path = Paths.get(jsonFile);
	}

	@Override
	public String getJsonResponse(String foodName) throws IOException {
		return new String(Files.readAllBytes(path));
	}

}
