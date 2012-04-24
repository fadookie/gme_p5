import com.eliotlash.gme_p5.*;

GameMusicEmu gme;

void setup() {
  gme = new GameMusicEmu(this);
  gme.debugOn();
  //gme.playFile("/Users/eliot/Documents/Processing/gme_p5_test/Mega_Man_3.nsf");
  gme.playFile("daniel.nsf");
}

void draw() {
}
