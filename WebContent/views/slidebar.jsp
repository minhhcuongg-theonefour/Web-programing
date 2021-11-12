<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!-- Sidebar-->
  <div class="border-end bg-white" id="sidebar-wrapper">
      <div class="sidebar-heading border-bottom bg-light">CMS</div>
      <div class="card-body">
          <div class="input-group">
              <input class="form-control" type="text" placeholder="Search..." aria-label="Search..." aria-describedby="button-search" />
              <button class="btn btn-primary" id="button-search" type="button"><i class="fa fa-search" aria-hidden="true"></i></button>
          </div>
      </div>
      <div class="list-group list-group-flush">
          <a class="list-group-item list-group-item-action list-group-item-light p-3" href="view-content" > <i
                  class="fa fa-table" aria-hidden="true"></i> View Contents</a>
          <a class="list-group-item list-group-item-action list-group-item-light p-3" href="add-content"><i
                  class="fa fa-pencil-square-o" aria-hidden="true"></i> Form Content</a>
      </div>
  </div>