package sample.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.DirectoryChooser;
import javafx.stage.Stage;
import sample.entity.ImageTableInfo;
import sample.service.ImageInfoManager;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class ImageInfoController implements Initializable {

    private static final String FILE_COUNT = "Files count: ";
    private static final String FILE_SIZE = "Total size: ";
    private static final String FILE_SIZE_METRICS = " GB";
    private static final double BYTE_TO_GB = 0.000000000931;

    @FXML
    public TextField tfOpen;
    @FXML
    public TableView tvImageInfo;
    @FXML
    public TableColumn tcName;
    @FXML
    public TableColumn tcSize;
    @FXML
    public TableColumn tcExtension;
    @FXML
    public TableColumn tcDepth;
    @FXML
    public TableColumn tcCompression;
    @FXML
    public TableColumn tcOptional;
    @FXML
    public Button btOpen;
    @FXML
    public Label tvFilesSize;
    @FXML
    public Label tvFilesCount;

    private DirectoryChooser directoryChooser;
    private Stage stage;

    private ObservableList<ImageTableInfo> tableData;

    private ImageInfoManager manager;


    @Override
    public void initialize(URL location, ResourceBundle resources) {

        directoryChooser = new DirectoryChooser();
        directoryChooser.setTitle("Select folder");

        manager = new ImageInfoManager();

        tableData = FXCollections.observableArrayList();

        tcName.setCellValueFactory(new PropertyValueFactory<>("name"));
        tcSize.setCellValueFactory(new PropertyValueFactory<>("size"));
        tcDepth.setCellValueFactory(new PropertyValueFactory<>("depth"));
        tcCompression.setCellValueFactory(new PropertyValueFactory<>("compression"));
        tcExtension.setCellValueFactory(new PropertyValueFactory<>("extension"));
        tcOptional.setCellValueFactory(new PropertyValueFactory<>("optional"));
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    public void openDirListener(ActionEvent actionEvent) {
        File file = directoryChooser.showDialog(this.stage);

        if (file == null) {
            return;
        }
        tfOpen.setText(file.getAbsolutePath());


        ArrayList<ImageTableInfo> images = manager.getImageInfo(file);

        tvFilesCount.setText(FILE_COUNT + images.size());
        double totalSizeInGB = BYTE_TO_GB * images.stream().mapToLong(ImageTableInfo::getPhysicalSize).sum();
        String sizeInGB = totalSizeInGB > 0.001 ? String.format("%.3f", totalSizeInGB) : "< 0,001";
        tvFilesSize.setText(FILE_SIZE + sizeInGB + FILE_SIZE_METRICS);

        tableData.setAll(images);
        tvImageInfo.setItems(tableData);
    }

}
