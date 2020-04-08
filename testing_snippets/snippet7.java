@MockBean
private TrackerService trackerService;

@Test
public void startTracking() {

    Mockito.doAnswer((Answer<Object>) invocationOnMock -> {
        Object[] args = invocationOnMock.getArguments();
        assertEquals("ABC1234", invocationOnMock.getArgument(0));
        return null;

    }).when(sessionTracker).sessionDestroyed(Mockito.any());

    TrackerClient client = new 

    TrackerClient("ws://localhost:9050/operational/websocket", "admin", "admin");
    client.connectAndWait();
    client.send("/operational/tracker/plate/ABC1234/track.start");
    TimeUnit.SECONDS.sleep(1);
}