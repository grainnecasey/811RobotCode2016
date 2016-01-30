package org.usfirst.frc.team811.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import javafx.scene.image.Image;

import java.awt.image.BufferedImage;
import java.awt.image.DataBufferByte;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.*;
import org.opencv.core.*;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;
import org.opencv.videoio.VideoCapture;
import javax.imageio.ImageIO;

public class VisionTracking extends Subsystem
{
	private ScheduledExecutorService timer;
	private VideoCapture capture;
	private boolean cameraActive;

	private Image grabFrame()
	{
		Image imageToShow = null;
		Mat frame = new Mat();
		// Mat frame = new Mat(frame1.getHeight(), frame1.getWidth(),
		// CvType.CV_8UC3);
		// byte[] pixels =
		// ((DataBufferByte)frame1.getRaster().getDataBuffer()).getData();
		// frame.put(0, 0, pixels);
		if (this.capture.isOpened())
		{
			try
			{
				Scalar hsv_min = new Scalar(83, 50, 50, 0);
				Scalar hsv_max = new Scalar(91, 255, 255, 0);
				// frame = this.doCanny(frame);
				Imgproc.cvtColor(frame, frame, Imgproc.COLOR_BGR2HSV);
				Core.inRange(frame, hsv_min, hsv_max, frame);
				Imgproc.GaussianBlur(frame, frame, new Size(3, 3), 3);
				imageToShow = mat2Image(frame);
			} catch (Exception e)
			{
				System.err.println("Exception during the frame elaboration: " + e);
			}
		}
		return imageToShow;
	}

	private Mat doCanny(Mat frame)
	{
		Mat grayImage = new Mat();
		Mat detectedEdges = new Mat();
		Imgproc.cvtColor(frame, grayImage, Imgproc.COLOR_BGR2GRAY);
		Imgproc.blur(grayImage, detectedEdges, new Size(3, 3));
		Imgproc.Canny(detectedEdges, detectedEdges, 10, 10 * 3, 3, false);
		Mat dest = new Mat();
		Core.add(dest, Scalar.all(0), dest);
		frame.copyTo(dest, detectedEdges);
		return frame;
	}

	private Image mat2Image(Mat frame)
	{
		MatOfByte buffer = new MatOfByte();
		Imgcodecs.imencode(".png", frame, buffer);
		return new Image(new ByteArrayInputStream(buffer.toArray()));
	}

	public void initDefaultCommand()
	{
		cameraActive = false;
		this.capture.open(0);
		if (this.capture.isOpened())
		{
			this.cameraActive = true;
			Runnable frameGrabber = new Runnable()
			{
				@Override
				public void run()
				{
					Image imageToShow = grabFrame();
					// currentFrame.setImage(imageToShow);

				}
			};
			this.timer = Executors.newSingleThreadScheduledExecutor();
			this.timer.scheduleAtFixedRate(frameGrabber, 0, 33, TimeUnit.MILLISECONDS);
		} else
		{
			// System.err.println("Cannot connect to camera.");
		}
	}
}
