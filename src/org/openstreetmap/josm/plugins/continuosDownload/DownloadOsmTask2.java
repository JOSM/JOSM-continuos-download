// License: GPL. See LICENSE file for details.
package org.openstreetmap.josm.plugins.continuosDownload;

import java.util.concurrent.Future;

import org.openstreetmap.josm.actions.downloadtasks.DownloadOsmTask;
import org.openstreetmap.josm.actions.downloadtasks.DownloadParams;
import org.openstreetmap.josm.data.Bounds;
import org.openstreetmap.josm.gui.progress.ProgressMonitor;
import org.openstreetmap.josm.io.OsmServerReader;

/**
 * This is a copy of the DownloadOsmTask that does not change the view after the area is downloaded.
 * It still displays modal windows and ugly dialog boxes :(
 */
public class DownloadOsmTask2 extends DownloadOsmTask {

    /**
     * Constructs a new {@code DownloadOsmTask2}.
     */
    public DownloadOsmTask2() {
        warnAboutEmptyArea = false;
    }

    @Override
    public Future<?> download(OsmServerReader reader, DownloadParams settings, Bounds downloadArea,
            ProgressMonitor progressMonitor) {
        return download(new DownloadTask2(settings, reader, progressMonitor), downloadArea);
    }

    protected class DownloadTask2 extends DownloadTask {

        public DownloadTask2(DownloadParams settings, OsmServerReader reader,
                ProgressMonitor progressMonitor) {
            super(settings, reader, progressMonitor, false);
        }
    }
}
