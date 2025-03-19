const menu = document.querySelector(".navbar__links")
const menuButton = document.querySelector(".navbar__icons")

menuButton.addEventListener('click', () => {
    menu.classList.toggle("navbar__open");
    menuButton.classList.toggle("open");
})

/*
document.addEventListener('DOMContentLoaded', () => {
    // Dữ liệu mẫu cho lớp học và gói tập
    const classes = [
        {name: 'Boxing', time: '18:00 - 20:00', instructor: 'Tuấn Anh'},
        { name: 'Yoga', time: '18:00 - 19:00', instructor: 'Mai Lanh' },
        { name: 'Zumba', time: '19:00 - 20:00', instructor: 'Anh Tuấn' },
      // ... thêm các lớp học khác
    ];
  
    // Hiển thị danh sách lớp học
    const classList = document.getElementById('classList');
    classes.forEach(classItem => {
      const classDiv = document.createElement('div');
      classDiv.innerHTML = `
        <h3>${classItem.name}</h3>
        <p>Thời gian: ${classItem.time}</p>
        <p>Huấn luyện viên: ${classItem.instructor}</p>
      `;
      classList.appendChild(classDiv);
    });
    // Xử lý sự kiện nút đăng ký
    const registerBtn = document.getElementById('registerBtn');
    registerBtn.addEventListener('click', () => {
      alert('Chức năng đăng ký đang được phát triển!');
    }); 
  }); 
  */
