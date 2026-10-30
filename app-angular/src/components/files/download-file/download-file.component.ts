import { Component, Input } from "@angular/core";
import { FilesService } from "../../../services/files/files.service";
import { InfoFileResponse } from "../../../models/files/info-file-response";


@Component({
  selector: 'app-download-file',
  imports: [],
  templateUrl: './download-file.component.html'
})
export class DownloadFileComponent {

  @Input()
  infoFile!: InfoFileResponse;

  constructor(private filesService: FilesService) {
  }

  getDownloadFileURL(): string {
    return this.filesService.downloadFile(this.infoFile);
  }

 }