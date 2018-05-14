import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'jhi-test-list',
  templateUrl: './test-list.component.html',
  styles: []
})
export class TestListComponent implements OnInit {

  constructor() { }

  ngOnInit() {
  }

  // @ViewChild('steptestList', { read: List }) steptestList: List;
  // @ViewChild('starttestList', { read: List }) starttestList: List;

  // actionSheet: ActionSheet;
  speakers: any[] = [];
  starttests: any[] = [{
    "title":"迷你测试",
    "subtitle":"52分钟",
    "profileminPic":"assets/img/speakers/mouse.jpg",
    "profilePic":"assets/img/advance-card-bttf.png",
    "desc1":"优点：用时短；全程52分钟",
    "desc2":"缺点：不如全真模考考察细致",
    "desc3":"适用人群：已经考过或者时间紧张的考生",
    "type":"minitest"
  },{
    "title":"全真测试",
    "subtitle":"225分钟",
    "profileminPic":"assets/img/speakers/lion.jpg",
    "profilePic":"assets/img/advance-card-jp.jpg",
    "desc1":"优点：考察细致，接近实考",
    "desc2":"缺点：耗时长；全程3小时45分钟左右",
    "desc3":"适用人群：未考过或希望细致评估的考生",
    "type":"alltest"
  }]

  steptests: any[] = [{
    "title":"阶段一测试",
    "subtitle":"52分钟",
    "profileminPic":"assets/img/speakers/mouse.jpg",
    "profilePic":"assets/img/advance-card-bttf.png",
    "desc1":"优点：用时短；全程52分钟",
    "desc2":"缺点：不如全真模考考察细致",
    "desc3":"适用人群：已经考过或者时间紧张的考生"
  },{
    "title":"阶段一测试",
    "subtitle":"225分钟",
    "profileminPic":"assets/img/speakers/lion.jpg",
    "profilePic":"assets/img/advance-card-jp.jpg",
    "desc1":"优点：考察细致，接近实考",
    "desc2":"缺点：耗时长；全程3小时45分钟左右",
    "desc3":"适用人群：未考过或希望细致评估的考生"
  }]
;

  segment = 'starttest';
  shownSessions: any = [];
  shownSegment: any;

  // constructor(
  //   public actionSheetCtrl: ActionSheetController,
  //   public navCtrl: NavController,
  //   public confData: ConferenceData,
  //   public config: Config,
  //   public inAppBrowser: InAppBrowser
  // ) { }

  // goToAllTest(type: any) {
  //   if(type == "minitest"){
  //     this.navCtrl.push(MiniTestPage);
  //   }else{
  //     this.navCtrl.push(TopListPage);
  //   }
  // }
  // goToTopList(){
  //    this.navCtrl.push(TopListPage);
  // }

  // updateList() {
  //   console.log(this.steptests)
  //   this.steptestList && this.steptestList.closeSlidingItems();
  // }

  // ionViewDidLoad() {
  //   this.confData.getSpeakers().subscribe((speakers: any[]) => {
  //     this.speakers = speakers;

  //   });
  // }

  // goToSessionDetail(session: any,type: any) {
  //   this.navCtrl.push(ExaminationDetailPage, {
  //     type: type,
  //     session: session
  //   });
  // }

  

  // goToSpeakerDetail(speakerName: any) {
  //   this.navCtrl.push(SpeakerDetailPage, {
  //     speaker: speakerName,
  //     name: speakerName.name
  //   });
  // }

  // openSpeakerShare(speaker: any) {
  //   let actionSheet = this.actionSheetCtrl.create({
  //     title: 'Share ' + speaker.name,
  //     buttons: [
  //       {
  //         text: 'Copy Link',
  //         handler: () => {
  //           console.log('Copy link clicked on https://twitter.com/' + speaker.twitter);
  //           if ((window as any)['cordova'] && (window as any)['cordova'].plugins.clipboard) {
  //             (window as any)['cordova'].plugins.clipboard.copy('https://twitter.com/' + speaker.twitter);
  //           }
  //         }
  //       },
  //       {
  //         text: 'Share via ...'
  //       },
  //       {
  //         text: 'Cancel',
  //         role: 'cancel'
  //       }
  //     ]
  //   });

  //   actionSheet.present();
  // }

  // openContact(speaker: any) {
  //   console.log(speaker)
  //   let actionSheet = this.actionSheetCtrl.create({
  //   });

  //   actionSheet.present();
  // }

}
