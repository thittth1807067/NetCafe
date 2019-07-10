package sample;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.util.Callback;

import javax.swing.text.html.ImageView;
import java.net.URL;
import java.util.ResourceBundle;

public class ControllerMember implements Initializable {
    @FXML
    private TableView<Member> tableView;
    @FXML
    private TableColumn<Member, String> usernameColumn;
    @FXML
    private TableColumn<Member, String> passwordwColumn;
    @FXML
    private TableColumn<Member, String> fullnameColumn;
    @FXML
    private TableColumn<Member, ImageView> avatarColumn;
    @FXML
    private TableColumn<Member,Long > remaintimeColumn;
    @FXML
    private JFXTextField txtAvatar;

    @FXML
    private JFXButton btnUpdate;

    @FXML
    private JFXButton btnDelete;

    @FXML
    private JFXTextField txtUsername;

    @FXML
    private JFXTextField txtRemaintime;


    public ControllerMember() {
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        this.tableView.setRowFactory(new Callback<TableView<Member>, TableRow<Member>>() {
            @Override
            public TableRow<Member> call(TableView<Member> param) {
                TableRow<Member> studentTableRow = new TableRow<>();
                studentTableRow.setOnMouseClicked(new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent event) {
                        if (!studentTableRow.isEmpty()) {
                            Member member = studentTableRow.getItem();
                            txtUsername.setText(member.getUsername());
                            txtRemaintime.setText(member.getRemaintime());
                            txtAvatar.setText(member.getAvatar());
                        }
                    }
                });
                return studentTableRow;
            }
        });

        this.avatarColumn.setCellValueFactory(new PropertyValueFactory<>("imageAvatar"));
        this.remaintimeColumn.setCellValueFactory(new PropertyValueFactory<>("remaintime"));
        this.usernameColumn.setCellValueFactory(new PropertyValueFactory<>("username"));
        this.tableView.setItems(loadMember());
    }


    private ObservableList<Member> loadMember() {
        ObservableList<Member> students = FXCollections.observableArrayList();
        students.add(new Member(txtUsername.getText(), txtRemaintime.getText(), txtAvatar.getText()));
        students.add(new Member(txtUsername.getText(), txtRemaintime.getText(), txtAvatar.getText()));
        students.add(new Member(txtUsername.getText(), txtRemaintime.getText(), txtAvatar.getText()));
        return students;
    }

    @FXML
    void saveStudent(ActionEvent event) {
        Member member = new Member(txtUsername.getText(), txtRemaintime.getText(), txtAvatar.getText());
        for (int i = 0; i < this.tableView.getItems().size(); i++) {
            Member st = this.tableView.getItems().get(i);
            if(st.getUsername().equals(member.getUsername())){
                this.tableView.getItems().remove(i);
            }
        }
        tableView.getItems().add(member);
    }

    @FXML
    void doDelete(ActionEvent event) {
       Member member = this.tableView.getSelectionModel().getSelectedItem();
        this.tableView.getItems().remove(member);
    }
}

