/*
 *  Copyright (c) 2007 - 2008 by Damien Di Fede <ddf@compartmental.net>
 *
 *   This program is free software; you can redistribute it and/or modify
 *   it under the terms of the GNU Library General Public License as published
 *   by the Free Software Foundation; either version 2 of the License, or
 *   (at your option) any later version.
 *
 *   This program is distributed in the hope that it will be useful,
 *   but WITHOUT ANY WARRANTY; without even the implied warranty of
 *   MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *   GNU Library General Public License for more details.
 *
 *   You should have received a copy of the GNU Library General Public
 *   License along with this program; if not, write to the Free Software
 *   Foundation, Inc., 675 Mass Ave, Cambridge, MA 02139, USA.
 */
package com.eliotlash.gme_p5;

import processing.core.PApplet;
import java.util.*;

/**
 * The <code>Minim</code> class is how you get what you want from JavaSound.
 * There are methods for obtaining objects for playing audio files:
 * {@link AudioSample}, {@link AudioSnippet}, and {@link AudioPlayer}. There
 * are methods for obtaining an {@link AudioRecorder}, which is how you record
 * audio to disk. There are methods for obtaining an {@link AudioInput}, which
 * is how you can monitor the computer's line-in or microphone, depending on
 * what the user has set as the record source. Finally there are methods for
 * obtaining an {@link AudioOutput}, which is how you can play audio generated
 * by your program. All of these classes are given {@link AudioStream AudioStreams} 
 * by <code>Minim</code>, which are <code>Thread</code>s that do the actual work 
 * of audio I/O. Because of this, you should always call the <code>close</code> 
 * method of an AudioXXX when you are finished with it.
 * <p>
 * <code>Minim</code> needs to know about your sketch so that it can load files 
 * from the sketch's data directory. For this reason, you must pass a PApplet to the 
 * constructor. 
 * 
 * @author Damien Di Fede
 */
public class GME_P5 {

        //Example consts:
        /** Specifies that you want a MONO AudioInput or AudioOutput */
        //public static final int MONO = 1;
        /** Specifies that you want a STEREO AudioInput or AudioOutput */
        //public static final int STEREO = 2;
        //public static final int LOOP_CONTINUOUSLY = -1;

        private static boolean DEBUG = false;
        private PApplet app;
        VGMPlayer player;
        boolean backgroundPlayback;

        /**
         * Creates an instance of Minim that will use the Javasound implementation.
         * 
         * @param parent
         *              the PApplet that will be used for loading files
         */
        public GME_P5(PApplet parent) {
                app = parent;

                try {
                        // Setup player and sample rate
                        int sampleRate = 44100;
                        player = new VGMPlayer(sampleRate);
                        player.setVolume(1.0);

                        backgroundPlayback = false;

                } catch (Exception e) {
                        error(e.getStackTrace().toString());
                }
        }

        public void helloWorld() {
                error("Hello, world!");
        }

        // Plays file at given URL (HTTP only). If it's an archive (.zip)
        // then path specifies the file within the archive. Track ranges
        // from 1 to number of tracks in file.
        public void playFile(String path) {
                try {
                        player.loadFileFromPath(path);
                        player.play();
                } catch (Exception e) {
                        error(e.getStackTrace().toString());
                }
        }

        // Stops currently playing file, if any
        public void stopFile() {
                try {
                        player.stop();
                } catch (Exception e) {
                        error(e.getStackTrace().toString());
                }
        }

        /**
         * Used internally to report error messages. These error messages will appear
         * in the console area of the PDE if you are running a sketch from the PDE,
         * otherwise they will appear in the Java Console.
         * 
         * @param s
         *          the error message to report
         */
        public static void error(String s) {
                PApplet.println("=== GME_P5 Error ===");
                PApplet.println("=== " + s);
                PApplet.println();
        }

        /**
         * Displays a debug message, but only if {@link #debugOn()} has been called. 
         * The message will be displayed in the console area of the PDE, 
         * if you are running your sketch from the PDE. 
         * Otherwise, it will be displayed in the Java Console.
         * 
         * @param s
         *          the message to display
         * @see #debugOn()
         */
        public static void debug(String s) {
                if (DEBUG) {
                        String[] lines = s.split("\n");
                        PApplet.println("=== GME_P5 Debug ===");
                        for (int i = 0; i < lines.length; i++) {
                                PApplet.println("=== " + lines[i]);
                        }
                        PApplet.println();
                }
        }

        /**
         * Turns on debug messages.
         */
        public void debugOn() {
                DEBUG = true;
        }

        /**
         * Turns off debug messages.
         * 
         */
        public void debugOff() {
                DEBUG = false;
        }

        /**
         * Stops Minim.
         * 
         * A call to this method should be placed inside of the stop() function of
         * your sketch. We expect that implemenations of the Minim 
         * interface made need to do some cleanup, so this is how we 
         * tell them it's time. 
         * 
         */
        public void stop() {
                try {
                        stopFile();
                } catch (Exception e) {
                        error(e.getStackTrace().toString());
                }
        }
        /**
         * Loads the requested file into an {@link AudioPlayer} 
         * with a buffer size of 1024 samples.
         * 
         * @param filename
         *          the file or URL you want to load
         * @return an <code>AudioPlayer</code> with a 1024 sample buffer
         * 
         * @see #loadFile(String, int)
         */
        /*
        public void loadFile(String filename)
        {
            loadFile(filename, 1024);
        }
         * 
         */

    /**
    * Loads the requested file into an {@link AudioPlayer} with 
    * the request buffer size.
    * 
    * @param filename
    *          the file or URL you want to load
    * @param bufferSize
    *          the sample buffer size you want
    *          
    * @return an <code>AudioPlayer</code> with a sample buffer of the requested size
    */
        /*
   public void loadFile(String filename, int bufferSize)
   {
     AudioRecordingStream rec = mimp.getAudioRecordingStream(filename, bufferSize);
     if ( rec != null )
     {
       return new AudioPlayer(rec);
     }
     else
     {
       error("Couldn't load the file " + filename);
     }
     return null;
   }  
         * 
         */
 

}
