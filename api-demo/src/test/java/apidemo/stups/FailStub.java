package apidemo.stups;

import java.io.IOException;

import apidemo.DataLayer;

public class FailStub extends DataLayer{
	@Override
	public String getJsonResponse(String foodname) throws IOException {
		throw new IOException("Stub - API Failure");
	}

}
